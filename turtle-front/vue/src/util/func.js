

let parse_article = function(article) {
  if (article.hasOwnProperty("createTime")) {
    article.createTime = format(new Date(article.createTime), "yyyy-MM-dd");
  }
  if (article.hasOwnProperty("updateTime")) {
    article.updateTime = format(new Date(article.updateTime), "yyyy-MM-dd");
  }
  return article;
};

let format = function(time, format) {
  let t = new Date(time);
  let tf = function (i) {
    return (i < 10 ? '0' : '') + i
  };
  return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function (a) {
    switch (a) {
      case 'yyyy':
        return tf(t.getFullYear());
        break;
      case 'MM':
        return tf(t.getMonth() + 1);
        break;
      case 'mm':
        return tf(t.getMinutes());
        break;
      case 'dd':
        return tf(t.getDate());
        break;
      case 'HH':
        return tf(t.getHours());
        break;
      case 'ss':
        return tf(t.getSeconds());
        break;
    }
  });
};


export {
  parse_article
}


