FROM node:20.11.0-alpine3.18
WORKDIR /app
COPY package.json .
RUN npm install
COPY . .
ENV HOST 0.0.0.0
EXPOSE 5173
CMD ["npm", "run", "dev"]