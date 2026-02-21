# Backend Service

## Configuration

This application uses environment variables for configuration.
Please copy `.env.example` to `.env` and fill in the required values.

### Required Environment Variables

| Variable | Description |
| :--- | :--- |
| `DB_USERNAME` | Database username |
| `DB_PASSWORD` | Database password |
| `JWT_SECRET` | Secret key for JWT token generation |
| `ETH_PASSWORD` | Password for the Ethereum wallet |
| `ETH_ADMIN_WALLET_FILENAME` | Path to the admin wallet file (e.g., `admin.wallet`) |
| `MAIL_USERNAME` | Email address for sending mails |
| `MAIL_PASSWORD` | Password for the email account |

### Running Locally

To run the application locally, ensure you have exported these environment variables in your shell or run configuration.

Example:
```bash
export DB_USERNAME=ssafy
export DB_PASSWORD=ssafy
export JWT_SECRET=your_secret
export ETH_PASSWORD=your_eth_password
export ETH_ADMIN_WALLET_FILENAME=/path/to/admin.wallet
export MAIL_USERNAME=your_email
export MAIL_PASSWORD=your_email_password

mvn spring-boot:run
```
