import { BASE_URL, TIME_OUT } from "./config";
import HYRequest from "./request";


const wfrequest = new HYRequest({
  baseURL: BASE_URL,
  timeout: TIME_OUT,
  interceptors: {
    requestSuccessFn: (config) => {
      const token = localStorage.getItem("SSM_TOKEN")
      if (config.headers && token) {
        config.headers.Authorization = token;
      }
      return config;
    },
  },
});
export default wfrequest;
