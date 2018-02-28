const DEV_URL = {
  LOAD_BLOG_LIST : "http://localhost:8080/article/getAll",
  LOAD_BLOG_DETAIL : "http://localhost:8080/article/getById",
  SAVE_BLOG : "http://localhost:8080/article/save"
};


const PRD_URL = {
  LOAD_BLOG_LIST : "/article/getAll",
  LOAD_BLOG_DETAIL : "article/getById",
  SAVE_BLOG : "article/save"
};

const POST_RESULT = {
  SUCCESS: 0,
  FAIL: 1
};

export { POST_RESULT, PRD_URL as API }
