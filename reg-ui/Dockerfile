from node:18 as deps
workdir /app
add package.json .
add package-lock.json .
run npm ci

from node:18 as runner
workdir /app
add . .
copy --from=deps /app/node_modules ./node_modules
run npm ci
env REGISTRY_HOST=
env REGISTRY_PORT=
cmd ["bash", "-c", "./build-env.sh && npm run start"]
