## Overview

The cache provides constant-time `get` and `put` operations by combining
a HashMap for key lookup with a doubly linked list to maintain access order.

Dummy head and tail nodes are used to simplify insertion and removal logic.

## Key Characteristics

- O(1) average-time `get` and `put`
- Eviction based on least recently used access

## Scope

This implementation is limited to a single-process, in-memory use case and
does not include:
- concurrency or thread-safety guarantees
- persistence or external storage
- distributed caching functionality
