FROM node as build-step

WORKDIR /usr/src/app

COPY ./src/main/web/package.json /usr/src/app

# RUN npm install -g @angular/cli

RUN npm install

COPY ./src/main/web /usr/src/app
COPY ./nginx.conf /etc/nginx

RUN npm run build

FROM nginx:alpine
VOLUME /var/cache/nginx
COPY ./nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=build-step /usr/src/app/dist/hroom-app/browser /usr/share/nginx/html
