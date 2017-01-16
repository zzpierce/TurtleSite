
function article(source) {
    this.id = source.id || 0;
    this.title = source.title || "title";
    this.tags = source.tags || "tag";
    this.content = source.content || "content";
    this.createTime = source.create_time || 0;
    this.updateTime = source.update_time || 0;
}

exports.article = article;