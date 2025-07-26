# 🛠 Custom Furnace MOD

**MOD ID**: `custom_furnace`  
対応バージョン：Forge 1.18.2（または使用しているバージョン）

---

## 🔧 概要

この MOD は、**Minecraft のかまど（Furnace）を模したカスタムブロック**を Forge 上で再現するものです。  
現在は TileEntity や GUI は未実装で、**向き（facing）と燃焼状態（lit）によって見た目を切り替える機能**まで完成しています。

---

## ✅ 現在対応済み機能

| 機能                           | 実装状況 |
|--------------------------------|-----------|
| 向き（North/East/South/West）設定 | ✔️         |
| 燃焼状態（lit=false / true）表示切替 | ✔️         |
| 初期設置時は lit=false（非点火）     | ✔️         |
| `setLit(world, pos, true/false)` による手動切替 | ✔️         |
| GUI や焼成ロジック（TileEntity）       | ❌（未実装） |

---

## 🗂 ファイル構成（lit 対応段階）
src/main/
├── java/com/example/customfurnace/
│   ├── CustomFurnace.java
│   ├── registry/
│   │   └── ModBlocks.java
│   └── block/
│       └── CustomFurnaceBlock.java
└── resources/assets/custom\_furnace/
├── blockstates/
│   └── custom\_furnace.json
├── models/
│   ├── block/
│   │   ├── custom\_furnace.json
│   │   └── custom\_furnace\_front\_lit.json
│   └── item/
│       └── custom\_furnace.json
└── textures/block/
├── custom\_furnace\_front.png
├── custom\_furnace\_front\_lit.png
├── custom\_furnace\_side.png
├── custom\_furnace\_top.png
└── custom\_furnace\_bottom.png

---

## 📌 各ファイルの役割

- **`CustomFurnace.java`**: MOD メインクラス。MOD ID・クリエイティブタブ定義・ModBlocks登録の責任を持ちます。
- **`ModBlocks.java`**: `DeferredRegister` で block / item を登録するクラス。
- **`CustomFurnaceBlock.java`**: `facing` プロパティと `lit` プロパティを設定。`setLit(...)` により状態切り替えが可能。
- **`blockstates/custom_furnace.json`**: 向きと燃焼状態に応じてモデルを切り替える設定が記述されています。
- **モデル JSON**:
  - `custom_furnace.json`: lit=false 用モデル
  - `custom_furnace_front_lit.json`: lit=true 用モデル
- **テクスチャ**:
  - `custom_furnace_front.png`: 通常状態の前面
  - `custom_furnace_front_lit.png`: 点火状態の前面
  - `side`, `top`, `bottom`: それぞれ対応テクスチャ

---

## 🚀 今後導入予定の機能

1. **TileEntity（BlockEntity）の追加**
   - `CustomFurnaceBlockEntity.java`: 焼成タイマー、インベントリ管理、NBT保存など
2. **メニュー・GUI の実装**
   - `CustomFurnaceMenu.java`（Container）
   - `CustomFurnaceScreen.java`（GUI描画）
3. **焼成ロジックの実装**
   - `CookingRecipeType` を使った焼成・燃料システム
4. **リソースと登録処理の整備**
   - GUI背景画像、進捗バー用 PNG 作成
   - `ModBlockEntities.java` / `ModMenus.java` による型登録処理追加

---

## 📚 参考・関連資料

- Furnace 等の既存実装を参考にした**Forge チュートリアル「Advanced Blocks」**  
  → 向き・状態によるモデル切り替えの例が詳しく解説されています :contentReference[oaicite:1]{index=1}  
- **MinecraftByExample プロジェクト**：簡潔な Forge × Minecraft 実装サンプル集として定評があります :contentReference[oaicite:2]{index=2}  

---