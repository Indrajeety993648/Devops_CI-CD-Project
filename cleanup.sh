#!/bin/bash

echo "🧹 Cleaning up..."
pkill -f "port-forward"
kind delete cluster --name order-cluster
echo "✅ Cleanup complete!"
```

---
