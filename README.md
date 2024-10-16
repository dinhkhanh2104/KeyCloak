# Simple Demo with Keycloak, Angular, and Spring Boot

If you want to run my code, follow these steps:

1. **Open your terminal** and enter the following command:

   ```bash
   docker run -p 8081:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:latest start-dev

  This command will run the Keycloak Admin Console on port 8081. After that, you can configure accounts with two roles: admin and non-admin for testing.

2. Run the **backend server** on port **4200**.

3. Run the **frontend server** on port **8080**.

4. Access **http://localhost:4200**. This will direct you to the Keycloak login form.
