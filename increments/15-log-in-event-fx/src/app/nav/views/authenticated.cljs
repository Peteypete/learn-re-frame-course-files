(ns app.nav.views.authenticated
  (:require [re-frame.core :as rf]
            [app.nav.views.nav-item :refer [nav-item]]
            ["@smooth-ui/core-sc" :refer [Box]]))

(defn authenticated
  []
  (let [active-nav @(rf/subscribe [:active-nav])
        nav-items [{:id :saved
                    :name "Saved"
                    :href "#saved"
                    :dispatch #(rf/dispatch [:set-active-nav :saved])}
                   {:id :recipes
                    :name "Recipes"
                    :href "#recipes"
                    :dispatch #(rf/dispatch [:set-active-nav :recipes])}
                   {:id :inboxes
                    :name "Inbox"
                    :href "#inbox"
                    :dispatch #(rf/dispatch [:set-active-nav :inboxes])}
                   {:id :become-a-chef
                    :name "Chef"
                    :href "#become-a-chef"
                    :dispatch #(rf/dispatch [:set-active-nav :become-a-chef])}
                   {:id :profile
                    :name "Profile"
                    :href "#profile"
                    :dispatch #(rf/dispatch [:set-active-nav :profile])}]]
    [:> Box {:display "flex"
             :justify-content "flex-end"
             :py 1}
     (for [{:keys [id name href dispatch]} nav-items]
       [nav-item {:key id
                  :id id
                  :name name
                  :href href
                  :dispatch-content dispatch
                  :active-nav active-nav}])]))

; This is the data I draw and the through it
[:href href :href "#saved"]  ----> [:href "#saved"]

;Step 1 for over each nav-items and pass to nav-item
[{:keys [id name href dispatch]} nav-items]
[nav-item {:key :recipies
           :id :recipies
           :name "Recipes"
           :href "#recipes"
           :dispatch #(rf/dispatch [:set-active-nav :recipes])
           :active-nav @(rf/subscribe [:active-nav])}]

;Step 2 build the html component with passed key values
[{:keys [id href name dispatch active-nav]}]
[:> Box {:key :recipies
         :as "a"
         :href "#recipes"
         :on-click #(rf/dispatch [:set-active-nav :recipes]) ; final hiccup/html made
         :ml 2
         :pb 10
         :border-bottom (when (= active-nav id) "2px solid #102A43")}
 name

;Viewing it from reverse, from the component being made.
 [:on-click dispatch  :dispatch dispatch :dispatch #(rf/dispatch [:set-active-nav :inboxes])] ---->  [:on-click #(rf/dispatch [:set-active-nav :inboxes])]
;;^from component     ^from for loop     ^from data


            [{:keys [id href name dispatch active-nav]}]]        [{:keys [id name href dispatch]} nav-items]
[:on-click dispatch                      :dispatch-content dispatch                              :dispatch #(rf/dispatch [:set-active-nav :inboxes])] ---->  [:on-click #(rf/dispatch [:set-active-nav :inboxes])]
;;^from component                        ^from for loop                                   ^from data


[{:keys [id href name dispatch-content active-nav]}]        [{:keys [id name href dispatch]} nav-items]
[:on-click dispatch-content                      :dispatch-content dispatch                              :dispatch #(rf/dispatch [:set-active-nav :inboxes])] ---->  [:on-click #(rf/dispatch [:set-active-nav :inboxes])]
;;^from component                        ^from for loop                                   ^from data
