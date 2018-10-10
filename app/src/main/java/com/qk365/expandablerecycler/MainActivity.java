package com.qk365.expandablerecycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qk365.widget.er.ExpandableRecyclerAdapter;
import com.qk365.widget.er.Node;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ExpandableRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler);

        mAdapter = new AreaExpandableRecyclerAdapter(mRecyclerView);
        mAdapter.setItems(getNodeList());
    }

    public List<Node<Area>> getNodeList() {
        List<Node<Area>> nodes = new ArrayList<>();
        List<Area> areas = getAreaList();

        for (int i = 0; i < 5; i++) {
            areas.addAll(getAreaList());
        }

        for (Area area : areas) {
            nodes.add(new AreaNode(0, area));
        }
        return nodes;
    }

    public List<Area> getAreaList() {
        return new Gson().fromJson(data, new TypeToken<List<Area>>() {
        }.getType());
    }

    private String data = "[\n" +
            "    {\n" +
            "      \"ceaName\": \"运营管理本部\",\n" +
            "      \"cerAddress\": null,\n" +
            "      \"ceaId\": 601,\n" +
            "      \"parentId\": 1,\n" +
            "      \"ceaCode\": \"1601001\",\n" +
            "      \"ceaAreaType\": 40,\n" +
            "      \"areaList\": [\n" +
            "        {\n" +
            "          \"ceaName\": \"青客上海（省级）公司\",\n" +
            "          \"cerAddress\": null,\n" +
            "          \"ceaId\": 600,\n" +
            "          \"parentId\": 1,\n" +
            "          \"ceaCode\": \"1600001\",\n" +
            "          \"ceaAreaType\": 30,\n" +
            "          \"areaList\": [\n" +
            "            {\n" +
            "              \"ceaName\": \"浦东城市公司\",\n" +
            "              \"cerAddress\": null,\n" +
            "              \"ceaId\": 599,\n" +
            "              \"parentId\": 1,\n" +
            "              \"ceaCode\": \"1599001\",\n" +
            "              \"ceaAreaType\": 20,\n" +
            "              \"areaList\": [\n" +
            "                {\n" +
            "                  \"ceaName\": \"徐汇分公司\",\n" +
            "                  \"cerAddress\": null,\n" +
            "                  \"ceaId\": 2,\n" +
            "                  \"parentId\": 1,\n" +
            "                  \"ceaCode\": \"0201\",\n" +
            "                  \"ceaAreaType\": 10,\n" +
            "                  \"areaList\": [\n" +
            "                    {\n" +
            "                      \"ceaName\": \"第一服务中心（徐汇1组）\",\n" +
            "                      \"cerAddress\": \"徐汇区船厂路101号A幢503室\",\n" +
            "                      \"ceaId\": 3,\n" +
            "                      \"parentId\": 2,\n" +
            "                      \"ceaCode\": \"0001\",\n" +
            "                      \"ceaAreaType\": 1,\n" +
            "                      \"areaList\": [\n" +
            "                        {\n" +
            "                          \"ceaName\": \"第一服务中心（徐汇1组）\",\n" +
            "                          \"cerAddress\": \"徐汇区船厂路101号A幢503室\",\n" +
            "                          \"ceaId\": 3,\n" +
            "                          \"parentId\": 2,\n" +
            "                          \"ceaCode\": \"0001\",\n" +
            "                          \"ceaAreaType\": 1,\n" +
            "                          \"areaList\": [\n" +
            "                            {\n" +
            "                              \"ceaName\": \"第一服务中心（徐汇1组）\",\n" +
            "                              \"cerAddress\": \"徐汇区船厂路101号A幢503室\",\n" +
            "                              \"ceaId\": 3,\n" +
            "                              \"parentId\": 2,\n" +
            "                              \"ceaCode\": \"0001\",\n" +
            "                              \"ceaAreaType\": 1,\n" +
            "                              \"areaList\": [\n" +
            "                                {\n" +
            "                                  \"ceaName\": \"第一服务中心（徐汇1组）\",\n" +
            "                                  \"cerAddress\": \"徐汇区船厂路101号A幢503室\",\n" +
            "                                  \"ceaId\": 3,\n" +
            "                                  \"parentId\": 2,\n" +
            "                                  \"ceaCode\": \"0001\",\n" +
            "                                  \"ceaAreaType\": 1\n" +
            "                                },\n" +
            "                                {\n" +
            "                                  \"ceaName\": \"第五十服务中心（普陀）\",\n" +
            "                                  \"cerAddress\": \"真北路2500号1616室\",\n" +
            "                                  \"ceaId\": 89,\n" +
            "                                  \"parentId\": 2,\n" +
            "                                  \"ceaCode\": \"0050\",\n" +
            "                                  \"ceaAreaType\": 1\n" +
            "                                }\n" +
            "                              ]\n" +
            "                            },\n" +
            "                            {\n" +
            "                              \"ceaName\": \"第五十服务中心（普陀）\",\n" +
            "                              \"cerAddress\": \"真北路2500号1616室\",\n" +
            "                              \"ceaId\": 89,\n" +
            "                              \"parentId\": 2,\n" +
            "                              \"ceaCode\": \"0050\",\n" +
            "                              \"ceaAreaType\": 1\n" +
            "                            }\n" +
            "                          ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                          \"ceaName\": \"第五十服务中心（普陀）\",\n" +
            "                          \"cerAddress\": \"真北路2500号1616室\",\n" +
            "                          \"ceaId\": 89,\n" +
            "                          \"parentId\": 2,\n" +
            "                          \"ceaCode\": \"0050\",\n" +
            "                          \"ceaAreaType\": 1\n" +
            "                        }\n" +
            "                      ]\n" +
            "                    },\n" +
            "                    {\n" +
            "                      \"ceaName\": \"第五十服务中心（普陀）\",\n" +
            "                      \"cerAddress\": \"真北路2500号1616室\",\n" +
            "                      \"ceaId\": 89,\n" +
            "                      \"parentId\": 2,\n" +
            "                      \"ceaCode\": \"0050\",\n" +
            "                      \"ceaAreaType\": 1\n" +
            "                    }\n" +
            "                  ]\n" +
            "                },\n" +
            "                {\n" +
            "                  \"ceaName\": \"自贸区分公司\",\n" +
            "                  \"cerAddress\": null,\n" +
            "                  \"ceaId\": 109,\n" +
            "                  \"parentId\": 1,\n" +
            "                  \"ceaCode\": \"0211\",\n" +
            "                  \"ceaAreaType\": 10,\n" +
            "                  \"areaList\": [\n" +
            "                    {\n" +
            "                      \"ceaName\": \"第十六服务中心（北蔡镇）\",\n" +
            "                      \"cerAddress\": \"莲溪路1099弄20号205室（鹏裕苑）\",\n" +
            "                      \"ceaId\": 28,\n" +
            "                      \"parentId\": 109,\n" +
            "                      \"ceaCode\": \"0016\",\n" +
            "                      \"ceaAreaType\": 1,\n" +
            "                      \"areaList\": [\n" +
            "                        {\n" +
            "                          \"ceaName\": \"第十六服务中心（北蔡镇）\",\n" +
            "                          \"cerAddress\": \"莲溪路1099弄20号205室（鹏裕苑）\",\n" +
            "                          \"ceaId\": 28,\n" +
            "                          \"parentId\": 109,\n" +
            "                          \"ceaCode\": \"0016\",\n" +
            "                          \"ceaAreaType\": 1,\n" +
            "                          \"areaList\": [\n" +
            "                            {\n" +
            "                              \"ceaName\": \"第十六服务中心（北蔡镇）\",\n" +
            "                              \"cerAddress\": \"莲溪路1099弄20号205室（鹏裕苑）\",\n" +
            "                              \"ceaId\": 28,\n" +
            "                              \"parentId\": 109,\n" +
            "                              \"ceaCode\": \"0016\",\n" +
            "                              \"ceaAreaType\": 1,\n" +
            "                              \"areaList\": [\n" +
            "                                {\n" +
            "                                  \"ceaName\": \"第十六服务中心（北蔡镇）\",\n" +
            "                                  \"cerAddress\": \"莲溪路1099弄20号205室（鹏裕苑）\",\n" +
            "                                  \"ceaId\": 28,\n" +
            "                                  \"parentId\": 109,\n" +
            "                                  \"ceaCode\": \"0016\",\n" +
            "                                  \"ceaAreaType\": 1\n" +
            "                                },\n" +
            "                                {\n" +
            "                                  \"ceaName\": \"第四十五服务中心（三林镇）\",\n" +
            "                                  \"cerAddress\": \"东方路1988号411室华南大厦\",\n" +
            "                                  \"ceaId\": 84,\n" +
            "                                  \"parentId\": 109,\n" +
            "                                  \"ceaCode\": \"0045\",\n" +
            "                                  \"ceaAreaType\": 1\n" +
            "                                }\n" +
            "                              ]\n" +
            "                            },\n" +
            "                            {\n" +
            "                              \"ceaName\": \"第四十五服务中心（三林镇）\",\n" +
            "                              \"cerAddress\": \"东方路1988号411室华南大厦\",\n" +
            "                              \"ceaId\": 84,\n" +
            "                              \"parentId\": 109,\n" +
            "                              \"ceaCode\": \"0045\",\n" +
            "                              \"ceaAreaType\": 1\n" +
            "                            }\n" +
            "                          ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                          \"ceaName\": \"第四十五服务中心（三林镇）\",\n" +
            "                          \"cerAddress\": \"东方路1988号411室华南大厦\",\n" +
            "                          \"ceaId\": 84,\n" +
            "                          \"parentId\": 109,\n" +
            "                          \"ceaCode\": \"0045\",\n" +
            "                          \"ceaAreaType\": 1\n" +
            "                        }\n" +
            "                      ]\n" +
            "                    },\n" +
            "                    {\n" +
            "                      \"ceaName\": \"第四十五服务中心（三林镇）\",\n" +
            "                      \"cerAddress\": \"东方路1988号411室华南大厦\",\n" +
            "                      \"ceaId\": 84,\n" +
            "                      \"parentId\": 109,\n" +
            "                      \"ceaCode\": \"0045\",\n" +
            "                      \"ceaAreaType\": 1\n" +
            "                    }\n" +
            "                  ]\n" +
            "                }\n" +
            "              ]\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]";
}
