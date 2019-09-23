app.service("brandService",function($http){
    		this.findPage=function(page,rows){
    			return $http.get("../brand/findPage?page="+page+"&rows="+rows);
    		}
    		
    		this.add=function(entity){
    			return $http.post("../brand/add",entity);
    		}
    		
    		this.update=function(entity){
    			return $http.post("../brand/update",entity);
    		}
    		
    		this.findOne=function(id){
    			return $http.get("../brand/findOne?id="+id);
    		}
    		
    		this.dele=function(selectIds){
    			return $http.get("../brand/delete?ids="+selectIds);
    		}
    		
    	});