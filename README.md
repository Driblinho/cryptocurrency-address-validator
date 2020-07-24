# Cryptocurrency address validator 
## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
## General info
This project is simple cryptocurrency address validator similar to [wallet-address-validator](https://github.com/ognus/wallet-address-validator).
### Supported cryptocurrencies:
* BTC
* DASH
* ETH
* TRX
## Technologies
Project is created with:
* JDK9+
* web3j version: 5.0.0
## Setup
```java
CryptoAddressValidator validator = new CryptoAddressValidator("1FzWLkAahHooV3kzTgyx6qsswXJ6sCXkSR");
validator.validate(); // run validator
validator.isValid(); // check adress validation
validator.detectCryptocurrency().get(); // return "BTC"
validator.isValid("BTC");
```


