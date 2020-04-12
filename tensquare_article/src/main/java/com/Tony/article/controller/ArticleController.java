package com.Tony.article.controller;

import com.Tony.article.pojo.Article;
import com.Tony.article.service.ArticleService;
import entity.Result;
import entity.StatusCode;
import jdk.net.SocketFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author AntonTony
 * @version 1.0
 * @GitHub https://github.com/AntonTony
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    // GET请求/article 查询文章全部列表
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        List<Article> list = articleService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",list);
    }
    // GET/article/{articleId}    根据ID查询文章
    @RequestMapping(value = "/{articleId}",method = RequestMethod.GET)
    public Result findById(@PathVariable String articleId){ //@PathVariable接收网页传参
        Article article = articleService.findById(articleId);
        return new Result(true,StatusCode.OK,"根据ID查询成功",article);
    }

    // POST/article  增加文章
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Article article){ //@RequestBody将json格式数据转化为对象
        articleService.addArticle(article);
        return new Result(true,StatusCode.OK,"添加文章成功");
    }

}
