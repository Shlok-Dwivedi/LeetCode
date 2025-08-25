char* simplifyPath(char* path) {
    char* res = (char*)malloc(strlen(path) + 1);
    int index = 0;
    int len = strlen(path);
    
    for(int i = 0; i < len; i++){
        if(path[i] == '/' && i == len - 1){
            continue;
        }
        else if(path[i] == '/' && i < len - 1 && path[i+1] == '/'){
            continue;
        }
        else if(path[i] == '/' && i < len - 2 && path[i+1] == '.' && path[i+2] == '.' && 
                (i == len - 3 || path[i+3] == '/')){
            i += 2;
            if(index > 1){
                index--;
                while(index > 0 && res[index] != '/'){
                    index--;
                }
            }
        }
        else if(path[i] == '/' && i < len - 1 && path[i+1] == '.' && 
                (i == len - 2 || path[i+2] == '/')){
            i += 1;
        }
        else{
            res[index] = path[i];
            index++;
        }
    }
    
    if(index == 0){
        res[index++] = '/';
    }
    
    res[index] = '\0';
    return res;
}