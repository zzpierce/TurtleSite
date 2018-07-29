package com.zz.back.service.impl;

import com.alibaba.fastjson.JSON;
import com.zz.back.dao.DinosaurDao;
import com.zz.back.model.DinosaurEntity;
import com.zz.back.model.exception.NetException;
import com.zz.back.model.exception.ParamException;
import com.zz.back.service.IDinosaurService;
import com.zz.back.util.image.ZImage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author pierce
 */
@Service
@Slf4j
public class DinosaurServiceImpl implements IDinosaurService {

    @Resource
    private DinosaurDao dinosaurDao;

    private static String GET_DINOSAUR_URL = "http://the-tinysaur-generator.herokuapp.com/?small=true&2";

    private static String DINO_FOLDER = "dino/";

    public DinosaurEntity create(String name) {
        //参数验证
        if (!checkName(name)) {
            throw new ParamException("名字只能是字母或数字");
        }
        //查找是否存在
        List<DinosaurEntity> dinosaurList = dinosaurDao.findByName(name);
        if (dinosaurList.size() > 0) {
            DinosaurEntity entity = dinosaurList.get(0);
            //判断图片是否存在
            String picName = entity.getPicName();
            //TODO
            return entity;
        } else {
            return createDinosaur(name);
        }
    }

    private DinosaurEntity createDinosaur(String name) {
        ZImage image;
        try {
            image = fetchDinosaur(name);
        } catch (IOException e) {
            throw new NetException(e.getMessage());
        }
        DinosaurEntity entity = new DinosaurEntity();

        entity.setName(name);
        entity.setPicName(image.getFileName());
        entity.setWidth(image.getWidth());
        entity.setHeight(image.getHeight());
        dinosaurDao.save(entity);
        return entity;
    }

    /**
     * 获取小恐龙照片
     * @return 照片存放地址
     * @throws IOException
     */
    private ZImage fetchDinosaur(String name) throws IOException {
        File path = new File(DINO_FOLDER);
        if (!path.exists()) {
            boolean dir = path.mkdir();
        }
        URL url = new URL(GET_DINOSAUR_URL);
        String id = Base64.getEncoder().encodeToString(name.getBytes());
        String fileName = id + ".png";
        String flipName = id + "_r.png";

        try (BufferedInputStream buf = new BufferedInputStream(url.openStream());
             FileOutputStream fout = new FileOutputStream(new File(DINO_FOLDER + fileName))) {
            int t;
            while ((t = buf.read()) != -1) {
                fout.write(t);
            }
        }
        ZImage image = new ZImage(DINO_FOLDER + fileName);
        image.flipHorizontally();
        image.saveAs(DINO_FOLDER + flipName);
        return image;
    }

    public static void main(String[] args) throws IOException {
        DinosaurServiceImpl dinosaurService = new DinosaurServiceImpl();
        DinosaurEntity fileName = dinosaurService.create("yoyo");
        System.out.println(JSON.toJSONString(fileName));
    }

    private boolean checkName(String name) {
        String pattern = "^[1-9a-zA-Z]*$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(name);
        return m.matches();
    }

}
