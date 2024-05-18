export const environment = {
  production: false,
  // to set the proxy on localhost:
  //    kubectl port-forward services/kong-gateway-proxy -n kong 8888:80 &
  proxy_ip: 'http://127.0.0.1:8888'
};
