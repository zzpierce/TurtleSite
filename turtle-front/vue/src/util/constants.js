const DEV_URL = {
  LOAD_BLOG_LIST : "http://localhost:8080/api/article/getAll",
  LOAD_BLOG_DETAIL : "http://localhost:8080/api/article/getById",
  SAVE_BLOG : "http://localhost:8080/api/article/save",
  SEARCH_BLOG : "http://localhost:8080/api/article/findByTag",
  LOAD_BLOG_PAGE : "http://localhost:8080/api/article/getPage"
};

const PRD_URL = {
  LOAD_BLOG_LIST : "/api/article/getAll",
  LOAD_BLOG_DETAIL : "api/article/getById",
  SAVE_BLOG : "api/article/save",
  SEARCH_BLOG : "api/article/findByTag",
  LOAD_BLOG_PAGE : "api/article/getPage"
};

const POST_RESULT = {
  SUCCESS: 0,
  FAIL: 1
};

export { POST_RESULT, DEV_URL as API }
