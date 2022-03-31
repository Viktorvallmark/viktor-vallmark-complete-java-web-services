package com.example.Complete;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class CsvReader {


    @RequestMapping(path = "/readcsv",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void ReadCsv(){



    }
}
