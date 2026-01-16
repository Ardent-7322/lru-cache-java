# LRU Cache (Java)

A small Java implementation of an in-memory LRU (Least Recently Used) cache.
This project was built to practice and demonstrate core data-structure
implementation and basic object-oriented design in Java.

## Overview

The cache supports constant-time `get` and `put` operations by combining:
- a HashMap for fast key lookup
- a doubly linked list to track usage order

Dummy head and tail nodes are used to simplify insertion and removal logic.

## Key Characteristics

- O(1) average-time `get` and `put`
- Explicit eviction of least recently used entries
- Simple, readable implementation focused on correctness

## Scope

This project is intentionally scoped and does not attempt to handle:
- concurrency or thread safety
- persistence or storage
- distributed or production-grade caching concerns
