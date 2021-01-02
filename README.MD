
# Requirements
* Java JDK 11
* Docker Desktop
* IDE (IntelliJ)


# Project Path
![](https://github.com/kapitalbank/microservice-app/blob/master/docs/arch.png)


# Vault installation and configuration to Docker
docker run -d -p 8200:8200 --name vault -e 'VAULT_DEV_ROOT_TOKEN_ID=myvaulttoken' -e 'VAULT_DEV_LISTEN_ADDRESS=0.0.0.0:8200' vault