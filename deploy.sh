#!/bin/bash

echo "🚀 Starting Deployment..."
kind create cluster --name order-cluster
kubectl apply -f k8s/complete-deployment.yaml
echo "⏳ Waiting 60 seconds for pods..."
sleep 60
kubectl get pods -n order-management
kubectl port-forward svc/order-management-service 8080:80 -n order-management &
sleep 5
curl http://localhost:8080/api/v1/orders/health
echo ""
echo "✅ Done! API at http://localhost:8080"