from node:18 as deps
workdir /app
add package.json .
add package-lock.json .
run npm ci

from node:18 as builder
workdir /app
copy --from=deps /app/node_modules ./node_modules
add . .
run npm run build

from node:18 as runner
workdir /app
copy --from=builder /app .
env REGISTRY_BASE_URL=
cmd ["bash", "-c", "./build-env.sh && npm run start"]
