//=======================================================================
// Copyright 2001 Jeremy G. Siek, Andrew Lumsdaine, Lie-Quan Lee, 
//
// Distributed under the Boost Software License, Version 1.0. (See
// accompanying file LICENSE_1_0.txt or copy at
// http://www.boost.org/LICENSE_1_0.txt)
//=======================================================================
#include <boost/config.hpp>
#include <vector>
#include <list>
#include <boost/graph/biconnected_components.hpp>
#include <boost/graph/adjacency_list.hpp>
#include <iterator>
#include <iostream>

namespace boost
{
    struct edge_component_t
    {
        enum
        { num = 555 };
        typedef edge_property_tag kind;
    }
    edge_component;
}

int main()
{
    freopen("input.txt","r",stdin);
    freopen("CACHE_51","w",stdout);

    using namespace boost;
    typedef adjacency_list < vecS, vecS, undirectedS,
        no_property, property < edge_component_t, std::size_t > >graph_t;
    typedef graph_traits < graph_t >::vertex_descriptor vertex_t;

    int n,m;
    scanf("%d %d",&n,&m);
    graph_t g(n);
    for(int i=0;i<m;i++)
    {
        int s,d;
        scanf("%d %d",&s,&d);
        add_edge(s,d,g);
    }


    property_map < graph_t, edge_component_t >::type
        component = get(edge_component, g);

    int num_comps = biconnected_components(g, component);
    printf("%d\n",num_comps);

        

  return 0;
}