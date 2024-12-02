import axios from "axios";
import type { AxiosInstance, InternalAxiosRequestConfig } from "axios";
import type { HYRequestConfig } from "./type";

class HYRequest {
  instance: AxiosInstance;

  constructor(config: HYRequestConfig) {
    this.instance = axios.create(config);

    // 全局请求拦截器
    this.instance.interceptors.request.use(
      (config: InternalAxiosRequestConfig) => config,
      (err) => Promise.reject(err)
    );

    // 全局响应拦截器
    this.instance.interceptors.response.use(
      (res) => res.data,
      (err) => Promise.reject(err)
    );

    // 实例特定的拦截器
    if (config.interceptors) {
      this.instance.interceptors.request.use(
        config.interceptors.requestSuccessFn,
        config.interceptors.requestFailureFn
      );
      this.instance.interceptors.response.use(
        config.interceptors.responseSuccessFn,
        config.interceptors.responseFailureFn
      );
    }
  }

  request<T = any>(config: HYRequestConfig<T>): Promise<T> {
    return new Promise<T>((resolve, reject) => {
      // 单次请求成功拦截处理
      if (config.interceptors?.requestSuccessFn) {
        config = config.interceptors.requestSuccessFn(
          config as InternalAxiosRequestConfig
        );
      }

      this.instance
        .request<any, T>(config)
        .then((res) => {
          // 单次响应成功拦截处理
          if (config.interceptors?.responseSuccessFn) {
            res = config.interceptors.responseSuccessFn(res);
          }
          resolve(res);
        })
        .catch((err) => {
          reject(err);
        });
    });
  }

  get<T = any>(config: HYRequestConfig<T>) {
    return this.request({ ...config, method: "GET" });
  }

  post<T = any>(config: HYRequestConfig<T>) {
    return this.request({ ...config, method: "POST" });
  }

  delete<T = any>(config: HYRequestConfig<T>) {
    return this.request({ ...config, method: "DELETE" });
  }

  patch<T = any>(config: HYRequestConfig<T>) {
    return this.request({ ...config, method: "PATCH" });
  }
}

export default HYRequest;
