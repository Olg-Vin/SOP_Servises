FROM node:18-alpine
WORKDIR /usr/src/app
COPY . .
RUN npm install -g http-server
EXPOSE 8000
CMD ["http-server", ".", "-p", "8000"]
