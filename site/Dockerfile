FROM node:22-alpine AS build
WORKDIR /app
COPY . .
RUN npm install
RUN npx ng build product-list --configuration production

FROM nginx:alpine
COPY --from=build /app/dist/product-list/browser /usr/share/nginx/html
COPY default.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
