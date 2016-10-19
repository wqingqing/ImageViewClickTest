
#引入

compile 'com.github.wqingqing:ImageViewClickTest:1.0'

#使用方法

- 1 设置图片点击区域 一个区域对应一个Polygon


     List<Polygon> polygons = new ArrayList<>();
     Polygon polygon = new Polygon("00");
     polygon.add(42.28571429f, 34.57627119f);
     polygon.add(50.14285714f, 34.57627119f);
     polygon.add(50.14285714f, 46.18644068f);
     polygon.add(42.28571429f, 46.18644068f);
     polygons.add(polygon);
     ClickImageView.setPolygons(polygons);




- 2 重写点击事件

        ClickImageView.setPolygons(polygons);
        ClickImageView.setOnViewClickListener(new ClickImageView.OnViewClick() {
            @Override
            public void onClick(String id) {
                Toast.makeText(MainActivity.this , id , Toast.LENGTH_SHORT).show();
            }
        });

