const DEV_URL = {
  LOAD_BLOG_LIST : "http://localhost:8080/article/getAll",
  LOAD_BLOG_DETAIL : "http://localhost:8080/article/getById"
};


const PRD_URL = {
  LOAD_BLOG_LIST : "/article/getAll",
  LOAD_BLOG_DETAIL : "article/getById"
};

export { DEV_URL as API }
