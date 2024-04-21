ng build # Immagine docker NGINX per servire l'app compilata
FROM nginx:latest

WORKDIR /usr/share/nginx/html

# Copia i file compilati dall'immagine di build precedente
COPY src/main/web/dist/hroom-app/browser /usr/share/nginx/html

# Copia il file di configurazione personalizzato di NGINX
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Espone la porta 80 per il traffico HTTP
EXPOSE 80

# Avvia NGINX in modalità daemon quando il container viene avviato
CMD ["nginx", "-g", "daemon off;"]
