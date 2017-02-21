
function article(source) {
    this.id = source.id || 0;
    this.title = source.title || "no-title";
    this.tags = source.tags || "";
    this.content = source.content || "";
    this.author = source.author || "nobody";

    var createTime = source.create_time ? source.create_time.toString() : null;
    var updateTime = source.update_time ? source.update_time.toString() : null;
    this.createTime = createTime.length < 10 ? createTime : createTime.substr(0, 10);
    this.updateTime = updateTime.length < 10 ? updateTime : updateTime.substr(0, 10);
}

exports.article = article;