#!/bin/bash

RESOURCE_GROUP="rg-singularity"
VM_NAME="vm-singularity"
LOCATION="brazilsouth"
ADMIN_USER="usuario"
ADMIN_PASSWORD="Senha123!DevOps"

# Criar grupo de recursos
az group create --name $RESOURCE_GROUP --location $LOCATION

# Criar VM com imagem Ubuntu2204 (confirmadamente suportada)
az vm create \
  --resource-group $RESOURCE_GROUP \
  --name $VM_NAME \
  --image Ubuntu2204 \
  --size Standard_B2s \
  --admin-username $ADMIN_USER \
  --admin-password $ADMIN_PASSWORD \
  --authentication-type password

# Liberar porta 8080
az vm open-port \
  --resource-group $RESOURCE_GROUP \
  --name $VM_NAME \
  --port 8080
