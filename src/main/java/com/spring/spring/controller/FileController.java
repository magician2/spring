package com.spring.spring.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.server.HttpServerResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spring.spring.entity.Files;
import com.spring.spring.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;


@RestController
@RequestMapping("/file")
//ファイルアップロード　インターフェース
public class FileController {
    @Value("${files.upload.path}")
    private String fileuploadPath;
    @Resource
    private FileMapper fileMapper;
    /**
     *
     * ファイルアップロードインターフェース
     * @param file  フロントから取得したファイル
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws IOException {

        //ファイルオリジナルName
        String originalFilename = file.getOriginalFilename();
        //ファイル形式を取得
        String type = FileUtil.extName(originalFilename);
        //ファイルサイズ取得
        long size = file.getSize();

        //ファイル唯一的識別コード
        String uuid = IdUtil.fastSimpleUUID();
        String fileUUid = uuid + StrUtil.DOT + type;
        File uploadFile = new File(fileuploadPath + fileUUid);
        //フォルダが存在いるか分岐
        if(!uploadFile.getParentFile().exists()){
            uploadFile.getParentFile().mkdirs();
        }
        //ファイルが存在しているかいないか（条件分岐）MD5取得　
        String url;
        //ファイルアップロード
        file.transferTo(uploadFile);
        //ファイルのmd5識別取得
        String md5 = SecureUtil.md5(uploadFile);
        //DBから同じmd5があるかの取得
        Files dbFiles = getFileByMd5(md5);

        //ファイルurl取得
        if( dbFiles != null){
            url = dbFiles.getUrl();
            //存在しているファイルを削除
            uploadFile.delete();
        }else {
            url = "http://localhost:9090/file/" + fileUUid;
        }
        //DBに保存
        Files saveFile = new Files();
        saveFile.setName(originalFilename);
        saveFile.setType(type);
        saveFile.setSize(size/1024);
        saveFile.setUrl(url);
        saveFile.setMd5(md5);
        fileMapper.insert(saveFile);
        return url;
    }

//    @GetMapping("/{fileUUID}")
//    public void download(@PathVariable String fileUUid, HttpServerResponse response) throws IOException{
//        File uploadFile = new File(fileuploadPath + fileUUid);
//        ServletOutputStream os =
//    }
@GetMapping("/{fileUUID}")
public void download(@PathVariable String fileUUID, HttpServletResponse response) throws IOException {
    // 根据文件的唯一标识码获取文件
    File uploadFile = new File(fileuploadPath + fileUUID);
    // 设置输出流的格式
    ServletOutputStream os = response.getOutputStream();
    response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileUUID, "UTF-8"));
    response.setContentType("application/octet-stream");

    // 读取文件的字节流
    os.write(FileUtil.readBytes(uploadFile));
    os.flush();
    os.close();
}
    /**
     * ファイルのmd5を通してファイル取得
     * @param md5
     * @return
     */
    public Files getFileByMd5(String md5){
        QueryWrapper<Files> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("md5",md5);
        List<Files> filesList = fileMapper.selectList(queryWrapper);
        return filesList.size() == 0 ? null : filesList.get(0);
    }
}
