
function article(source) {
    this.id = source.id || 0;
    this.title = source.title || "title";
    this.tags = source.tags || "tag";
    this.content = source.content || "content";
    this.createTime = source.createTime || 0;
    this.updateTime = source.updateTime || 0;
}

exports.article = article;