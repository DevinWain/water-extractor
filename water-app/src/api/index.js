import { get, post } from './request'

const HttpManager = {
  
  // 获取指定歌单的评分
  getResized: (url) => get(`api/resize/?url=${url}`),
  getOtsu1d: (url) => get(`api/otsu-1d/?url=${url}`),
}

export { HttpManager }
