# DABO Backend

## Environment Configuration

This project requires environment variables to be set for sensitive configuration.
See `.env.example` for the list of required variables.

### Setting up Environment Variables

You can set these variables in your shell profile, or use an IDE plugin to load them.
Spring Boot can also resolve them from system environment variables.

Example:
```bash
export DB_USERNAME=ssafy
export DB_PASSWORD=ssafy
export JWT_SECRET=your_secret_key
export ETH_PASSWORD=your_eth_password
export ETH_ADMIN_WALLET_FILENAME=admin.wallet
export MAIL_USERNAME=your_email@gmail.com
export MAIL_PASSWORD=your_email_password
```

### Ethereum Wallet

The application requires an Ethereum wallet file (keystore).
The path to this file is configured via `ETH_ADMIN_WALLET_FILENAME`.

**Important:**
For the current implementation (`CommonUtil.java`), the wallet file MUST be located in the classpath (e.g., `src/main/resources/`).
For local development, place your wallet file (e.g., `admin.wallet`) in `src/main/resources/`.
It is already added to `.gitignore` to prevent accidental commitment.
