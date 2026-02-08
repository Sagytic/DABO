# Backend Application

## Configuration

The application requires the following environment variables to be set. You can set them in your shell or use a `.env` file (if you have a mechanism to load it, or just for reference).

See `.env.example` for the list of required variables:

- `DB_USERNAME`: Database username
- `DB_PASSWORD`: Database password
- `JWT_SECRET`: Secret key for JWT token generation
- `ETH_PASSWORD`: Password for the Ethereum wallet
- `MAIL_USERNAME`: Email address for sending confirmation emails
- `MAIL_PASSWORD`: Password for the email account

## Running the Application

Ensure you have Java 8 installed (or compatible version).

```bash
./mvnw spring-boot:run
```

Ensure the environment variables are exported before running the command.
