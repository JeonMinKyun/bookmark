#!/bin/sh

echo "Kubernetes cluster initializing..."

kind create cluster --config kind-config.yml

echo "\n-----------------------------------------------------\n"

echo "NGINX Ingress installing..."

kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/main/deploy/static/provider/kind/deploy.yaml

echo "\n-----------------------------------------------------\n"

echo "NGINX Ingress reading..."

sleep 10

kubectl wait --namespace ingress-nginx \
  --for=condition=ready pod \
  --selector=app.kubernetes.io/component=controller \
  --timeout=180s

echo "\n"

echo "Happy Days"