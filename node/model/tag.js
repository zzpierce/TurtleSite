function tag(source) {
    this.id = source.id || 0;
    this.name = source.name || "";
}

exports.tag = tag;