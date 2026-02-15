# Backend Configuration

This backend application uses Spring Boot and requires several environment variables to be set for security and configuration purposes.

## Environment Variables

The following environment variables must be defined before running the application:

| Variable | Description | Example |
|----------|-------------|---------|
| `DB_USERNAME` | Database username | `ssafy` |
| `DB_PASSWORD` | Database password | `securepassword` |
| `JWT_SECRET` | Secret key for JWT token generation | `long_random_string` |
| `ETH_PASSWORD` | Password for the Ethereum wallet | `wallet_password` |
| `ETH_ADMIN_WALLET_FILENAME` | Filename of the admin wallet in `src/main/resources` or classpath | `admin.wallet` |
| `MAIL_USERNAME` | Email address for sending confirmation emails | `admin@example.com` |
| `MAIL_PASSWORD` | Password or app password for the email account | `email_password` |

## How to Set Environment Variables

### Linux / macOS

```bash
export DB_USERNAME=ssafy
export DB_PASSWORD=yourpassword
# ... export other variables
./mvnw spring-boot:run
```

### Windows (PowerShell)

```powershell
$env:DB_USERNAME="ssafy"
$env:DB_PASSWORD="yourpassword"
# ... set other variables
./mvnw spring-boot:run
```

### Using IntelliJ IDEA

1. Go to **Run/Debug Configurations**.
2. Select your Spring Boot application configuration.
3. In the **Environment variables** field, add the variables (e.g., `DB_USERNAME=ssafy;DB_PASSWORD=pass`).

## Security Note

Never commit actual secrets (passwords, keys) to version control. Use `.env` files (if supported by your setup) or system environment variables.
