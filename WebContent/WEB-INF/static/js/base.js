$.fn
		.extend({
			sMultiple : function() {
				function t() {
				    
					var t = $(this).parents(n.selector).index();
					//修改为禁止重复添加
					var targetList=$(e[t]).find("option");
					var sourceList=$(d[t]).find("option:checked");
					for(var i=0;i<sourceList.length;i++){
						var temp=sourceList[i].text;
						//做标记
						var flag='0';
						for(var j=0;j<targetList.length;j++){
							if(temp==targetList[j].text){
								flag='1';
							}
						}
						if(flag=='0'){
							//添加
							$(e[t]).append(sourceList[i]);
						}
					}		
				}
				function i() {
					var t = $(this).parents(n.selector).index();
					$(e[t]).find("option:checked").appendTo($(d[t]))
				}
				var n = this, d = n.find("[data-slt=left]"), e = n
						.find("[data-slt=right]"), a = n
						.find("[data-arrow=left]"), c = n
						.find("[data-arrow=right]");
				d.dblclick(t), e.dblclick(i), a.click(t), c.click(i)
			}
		});