package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



@Controller
public class BeanController
{

    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public String handleFileUpload(@RequestParam("name_file")String subcategory, @RequestParam("file") MultipartFile file)
    {
        System.out.println(subcategory);
        String name = null;
        if (!file.isEmpty())
        {
            try
            {
                byte[] bytes = file.getBytes();
                name = file.getOriginalFilename();

                String rootPath = "src/main/resources/public/image/";

                File dir = new File(rootPath  + subcategory);

                if(!dir.exists())
                {
                    dir.mkdir();
                }

                File uploadedFile = new File(dir.getAbsolutePath() + File.separator + name);
                file.transferTo(uploadedFile);
//                DataOutputStream stream = new DataOutputStream(new FileOutputStream(uploadedFile));
//                stream.write(bytes);
//                stream.flush();
//                stream.close();
//                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
//                stream.write(bytes);
//                stream.flush();
//                stream.close();

                return "admin/admin-page";
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            return "admin/admin-page";
        }
        return "admin/admin-page";
    }


    @RequestMapping(value = "/getListImage", params = {"subcategory"})
    @ResponseBody
    public List<String> getImage(@RequestParam(value = "subcategory")String subcategory)
    {
        File dir = new File("src/main/resources/public/image/" + subcategory + "/");

        boolean isDir = dir.isDirectory();
        String[] imageFiles = null;

        List<String> listNameImage = new ArrayList<>();
        if(isDir)
        {
            imageFiles = dir.list();

            for(int i = 0; i<imageFiles.length; i++)
            {
                listNameImage.add("/image/" + subcategory + "/" + imageFiles[i]);
                System.out.println(listNameImage.get(i));
            }
        }
        return listNameImage;
    }
}
