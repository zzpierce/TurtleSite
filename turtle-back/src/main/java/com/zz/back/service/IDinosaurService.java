package com.zz.back.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * @author pierce
 */
@Slf4j
@Service
public class IDinosaurService {

    private static String GET_DINOSAUR_URL = "http://the-tinysaur-generator.herokuapp.com/?small=true&2";

    private static String DINO_FOLDER = "dino";

    public void getPic() throws IOException {
        File path = new File(DINO_FOLDER);
        if (!path.exists()) {
            boolean dir = path.mkdir();
        }
        URL url = new URL(GET_DINOSAUR_URL);
        try (BufferedInputStream buf = new BufferedInputStream(url.openStream());
             FileOutputStream fout = new FileOutputStream(new File(DINO_FOLDER + "/a.png"))) {
            int t;
            while ((t = buf.read()) != -1) {
                fout.write(t);
            }
        } catch (IOException e) {
            log.error("获取 dinosaur 出错", e);
        }
    }

    public static void main(String[] args) throws IOException {
        new IDinosaurService().getPic();
    }

}
