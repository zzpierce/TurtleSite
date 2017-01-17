
function article(source) {
    this.id = source.id || 0;
    this.title = source.title || "title";
    this.tags = source.tags || "tag";
    this.content = source.content || "content";

    var createTime = source.create_time.toString();
    var updateTime = source.update_time.toString();
    this.createTime = createTime.length < 10 ? createTime : createTime.substr(0, 10);
    this.updateTime = updateTime.length < 10 ? updateTime : updateTime.substr(0, 10);
}

exports.article = article;