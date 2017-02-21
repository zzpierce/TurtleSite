var Tag = require('./tag').tag;
var mysql = require('mysql');
var dataSource = require('../config/config').dataSource;

function tag_dao(){
    //创建数据库连接
    var dbConnection = mysql.createConnection(dataSource);

    this.retrieve = function(id, params, callback){
        var tags = [];
        // 执行数据库查询，在回调函数中处理查询结果
        dbConnection.query('SELECT * FROM tag where id = ?', [id], function(err, rows, fields) {
            if (err) throw err;
            for(var i=0; i<rows.length; i++){
                var tag = new Tag(rows[i]);
                tags.push(tag);
            }
            callback(tags);
            dbConnection.end();
        });
    };

    this.list = function(id, params, callback){
        var tags = [];
        // 执行数据库查询，在回调函数中处理查询结果
        dbConnection.query('SELECT * FROM tag', function(err, rows, fields) {
            if (err) throw err;
            for(var i=0; i<rows.length; i++){
                var tag = new Tag(rows[i]);
                tags.push(tag);
            }
            //执行回调函数
            callback(tags);
            dbConnection.end();
        });
    };

    this.postMember = function(id, params, callback){
        if(arguments.length >= 2){
            var newId = arguments[0];
            // 执行数据库插入操作，通过Javascript 对象传递参数
            dbConnection.query('INSERT INTO tag SET ?', {title: params.title, tags: params.tags, content: params.content} , function(err, result) {
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
            dbConnection.query('INSERT INTO tag SET ?',
                {
                    name: params.name,
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
            dbConnection.query('UPDATE tag SET name = ? where id = ?', [params.name, id] , function(err, result) {
                if (err) throw err;
                //执行回调函数
                callback({id: newId});
                dbConnection.end();
            });
        }
    };

    this.deleteMember = function(id, params, callback){
        // 执行数据库删除操作
        dbConnection.query('DELETE FROM tag where id = ?', [id] , function(err, result) {
            if (err) throw err;
            //执行回调函数
            callback({id: id});
            dbConnection.end();
        });
    };
}

exports.dao = tag_dao;

