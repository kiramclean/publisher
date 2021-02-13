(ns publisher.core
  (:require [reagent.core :as r]))

(defn app []
  [:div.container "Hello world"])

(defn ^:export main []
  (r/render
    [app]
    (.getElementById js/document "app")))
