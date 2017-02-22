var Article = require('./article').article;
var mysql = require('mysql');
var dataSource = require('../config/config').dataSource;

function article_dao(){
    //创建数据库连接
    var dbConnection = mysql.createConnection(dataSource);

    this.retrieve = function(id, params, callback){
        var articles = [];
        // 执行数据库查询，在回调函数中处理查询结果
        dbConnection.query('SELECT * FROM article where id = ?', [id], function(err, rows, fields) {
            if (err) throw err;
            for(var i=0; i<rows.length; i++){
                var article = new Article(rows[i]);
                articles.push(article);
            }
            callback(articles);
            dbConnection.end();
        });
    };

    this.list = function(id, params, callback){
        var articles = [];
        // 执行数据库查询，在回调函数中处理查询结果
        dbConnection.query('SELECT * FROM article', function(err, rows, fields) {
            if (err) throw err;
            for(var i=0; i<rows.length; i++){
                var article = new Article(rows[i]);
                articles.push(article);
            }
            console.log(articles);
            //执行回调函数
            callback(articles);
            dbConnection.end();
        });
    };

    this.postMember = function(id, params, callback){
        if(arguments.length >= 2){
            var newId = arguments[0];
            // 执行数据库插入操作，通过Javascript 对象传递参数
            dbConnection.query('INSERT INTO article SET ?', {title: params.title, tags: params.tags, content: params.content} , function(err, result) {
                if (err) throw err;
                //执行回调函数
                callback(result);
                dbConnection.end();
            });
        }
    };

    this.create = function(id, params, callback) {
        if(arguments.length >=2 ) {
            var date = new Date();
            dbConnection.query('INSERT INTO article SET ?',
                {
                    title: params.title,
                    tags: params.tags,
                    content: params.content,
                    create_time: date,
                    update_time: date
                }, function(err, result) {
                    if (err) throw err;
                    //执行回调函数
                    callback(result);
                    dbConnection.end();
                }
            );
        }
    };


    this.update = function(id, params, callback){
        if(arguments.length >= 2){
            var newId = arguments[0];
            var params = arguments[1];
            // 执行数据库更新操作
            dbConnection.query('UPDATE article SET title = ?, tags=?, content=? where id = ?', [params.title,  params.tags, params.content, id] , function(err, result) {
                if (err) throw err;
                //执行回调函数
                callback({id: newId});
                dbConnection.end();
            });
        }
    };

    this.deleteMember = function(id, params, callback){
        // 执行数据库删除操作
        dbConnection.query('DELETE FROM article where id = ?', [id] , function(err, result) {
            if (err) throw err;
            //执行回调函数
            callback({id: id});
            dbConnection.end();
        });
    };
}

exports.dao = article_dao;
/**
 * Created by zz on 2017/1/15.
 */
