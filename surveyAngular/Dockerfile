# Use a Node base image
FROM node:latest

# Set the working directory in the container
WORKDIR /app

# Copy package.json and package-lock.json (if available)
COPY package*.json /app/

# Install project dependencies
RUN npm install

# Install Angular CLI globally
RUN npm install -g @angular/cli

# Copy the rest of your app's source code
COPY . /app

# Angular CLI port
EXPOSE 4200

# Start the application
CMD ["ng", "serve", "--host", "0.0.0.0"]