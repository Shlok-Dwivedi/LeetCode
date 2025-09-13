struct hash_entry {
    int key;            // The number from the nums array
    int value;          // The index of that number
    UT_hash_handle hh;  // This makes the structure hashable
};

bool containsNearbyDuplicate(int* nums, int numsSize, int k) {
    // Initialize the hash table to NULL
    struct hash_entry *map = NULL;

    for (int i = 0; i < numsSize; i++) {
        int current_num = nums[i];
        struct hash_entry *entry;

        // Search for the current number in our hash map
        HASH_FIND_INT(map, &current_num, entry);

        // If the entry is found in the map...
        if (entry != NULL) {
            // Check if the distance is within k
            if (i - entry->value <= k) {
                // We found a valid pair!
                // Free the hash table memory before returning to prevent memory leaks.
                struct hash_entry *current, *tmp;
                HASH_ITER(hh, map, current, tmp) {
                    HASH_DEL(map, current); // This deletes the item from the hash table.
                    free(current);          // This frees the memory allocated for the item.
                }
                return true; // Return true as we found the duplicate.
            } else {
                // The duplicate is too far away, so update its index to the current one.
                entry->value = i;
            }
        } else {
            // This number is not in the map yet, so let's add it.
            entry = malloc(sizeof(struct hash_entry));
            entry->key = current_num;
            entry->value = i;
            HASH_ADD_INT(map, key, entry);
        }
    }

    // If we finish the loop, no nearby duplicates were found.
    // We still need to free the map memory before we exit.
    struct hash_entry *current, *tmp;
    HASH_ITER(hh, map, current, tmp) {
        HASH_DEL(map, current);
        free(current);
    }
    
    return false;
}