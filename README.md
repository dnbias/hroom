# HourRoom
Project for TAAS course UniTo 2023/24
## Class Diagram
<img title="class diagram" src="./docs/class_diagram.drawio.png">

## Starting the Project
``` bash
❯ minikube start
```

Install Kong[^1] to manage the gateway:
``` bash
❯ kubectl apply -f https://github.com/kubernetes-sigs/gateway-api/releases/download/v1.0.0/standard-install.yaml
❯ helm repo add kong https://charts.konghq.com
❯ helm repo update
❯ helm install kong kong/ingress -n kong --create-namespace 
```

Port-forward for ease of access:
``` bash
❯ kubectl port-forward services/kong-gateway-proxy -n kong 8888:80 & &>/dev/null
```

Install rabbitmq:[^2]
``` bash
❯ kubectl apply -f "https://github.com/rabbitmq/cluster-operator/releases/latest/download/cluster-operator.yml"
```

Apply all the kubernetes files:
``` bash
❯ kubectl apply -f kubernetes
```

Port-forward rabbitmq to access the dashboard:
``` bash
❯ kubectl port-forward "service/hroom-mq" 15672 &
```

Check the status of the deployments:
``` bash
❯ kubectl get pods
```

The web-app is accessible at http://localhost:8888.
Services are accessible through the kong gateway at http://localhost:8888/api/v1/name

Test them with curl:
``` bash
❯ curl -s http://localhost:8888/api/v1/insertion | jq '.'
```

You might need to disable CORS to make the web-app work.

You can scale the deployments using the script ```scale-deployments```.
``` bash
❯ ./scale-deployments -h
```

[^1]: See https://docs.konghq.com/kubernetes-ingress-controller/latest/get-started/
[^2]: See https://www.rabbitmq.com/kubernetes/operator/install-operator
## Building
To build the modules use the docker-compose like so:
``` bash
❯ docker compose build insertion-microservice
```
To build everything:
``` bash
❯ docker compose build
```
